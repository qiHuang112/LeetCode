package leetcode

import java.util.*

/*
机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
-2：向左转 90 度
-1：向右转 90 度
1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。
第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。

示例 1：
输入: commands = [4,-1,3], obstacles = []
输出: 25
解释: 机器人将会到达 (3, 4)

示例 2：
输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出: 65
解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处

提示：
0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
答案保证小于 2 ^ 31

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/walking-robot-simulation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun robotSim1(commands: IntArray, obstacles: Array<IntArray>): Int {
    // 当前方向 北0 东1 南2 西3
    var curDirection = 0
    // 当前坐标
    var (x, y) = 0 to 0
    // 最大欧氏距离
    var res = 0
    // 障碍物
    val obstacleX = mutableMapOf<Int, MutableList<Int>>()
    val obstacleY = mutableMapOf<Int, MutableList<Int>>()
    for (obstacle in obstacles) {
        obstacleX[obstacle[0]] = (obstacleX[obstacle[0]] ?: mutableListOf()).apply { add(obstacle[1]) }
        obstacleY[obstacle[1]] = (obstacleY[obstacle[1]] ?: mutableListOf()).apply { add(obstacle[0]) }
    }
    for (command in commands) {
        when (command) {
            -1 -> {
                curDirection += 1
                curDirection %= 4
            }
            -2 -> {
                curDirection += 3
                curDirection %= 4
            }
            else -> {
                when (curDirection) {
                    0 -> {
                        val list = obstacleX[x]
                        if (list == null) {
                            y += command
                        } else {
                            var cur = y
                            for (i in 1..command) {
                                if (y + i !in list) {
                                    cur = y + i
                                } else {
                                    break
                                }
                            }
                            y = cur
                        }
                    }
                    1 -> {
                        val list = obstacleY[y]
                        if (list == null) {
                            x += command
                        } else {
                            var cur = x
                            for (i in 1..command) {
                                if (x + i !in list) {
                                    cur = x + i
                                } else {
                                    break
                                }
                            }
                            x = cur
                        }
                    }
                    2 -> {
                        val list = obstacleX[x]
                        if (list == null) {
                            y -= command
                        } else {
                            var cur = y
                            for (i in 1..command) {
                                if (y - i !in list) {
                                    cur = y - i
                                } else {
                                    break
                                }
                            }
                            y = cur
                        }
                    }
                    3 -> {
                        val list = obstacleY[y]
                        if (list == null) {
                            x -= command
                        } else {
                            var cur = x
                            for (i in 1..command) {
                                if (x - i !in list) {
                                    cur = x - i
                                } else {
                                    break
                                }
                            }
                            x = cur
                        }
                    }
                }
            }
        }
//        println("[$x,$y]")
        res = maxOf(res, x * x + y * y)
    }
    return res
}

/**
 * 纯属阅读理解题，最后搞个最大欧式距离，就恶心人呗
 */
private fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    // 当前方向 北0 东1 南2 西3
    var curDirection = 0
    // 当前坐标
    var (x, y) = 0 to 0
    // 最大欧氏距离
    var res = 0
    // 障碍物
    val obstacleX = mutableMapOf<Int, TreeSet<Int>>()
    val obstacleY = mutableMapOf<Int, TreeSet<Int>>()
    for (obstacle in obstacles) {
        obstacleX[obstacle[0]] = (obstacleX[obstacle[0]] ?: TreeSet()).apply { add(obstacle[1]) }
        obstacleY[obstacle[1]] = (obstacleY[obstacle[1]] ?: TreeSet()).apply { add(obstacle[0]) }
    }
    for (command in commands) {
        when (command) {
            -1 -> {
                curDirection += 1
                curDirection %= 4
            }
            -2 -> {
                curDirection += 3
                curDirection %= 4
            }
            else -> {
                when (curDirection) {
                    0 -> {
                        val list = obstacleX[x]?.toList()
                        if (list == null) {
                            y += command
                        } else {
                            var index = 0
                            while (index < list.size && list[index] <= y) {
                                index++
                            }
                            if (index == list.size) {
                                y += command
                            } else {
                                if (list[index] - y > command) {
                                    y += command
                                } else {
                                    y = list[index] - 1
                                }
                            }
                        }
                    }
                    1 -> {
                        val list = obstacleY[y]?.toList()
                        if (list == null) {
                            x += command
                        } else {
                            var index = 0
                            while (index < list.size && list[index] <= x) {
                                index++
                            }
                            if (index == list.size) {
                                x += command
                            } else {
                                if (list[index] - x > command) {
                                    x += command
                                } else {
                                    x = list[index] - 1
                                }
                            }
                        }
                    }
                    2 -> {
                        val list = obstacleX[x]?.toList()
                        if (list == null) {
                            y -= command
                        } else {
                            var index = list.lastIndex
                            while (index >= 0 && list[index] >= y) {
                                index--
                            }
                            if (index < 0) {
                                y -= command
                            } else {
                                if (y - list[index] > command) {
                                    y -= command
                                } else {
                                    y = list[index] + 1
                                }
                            }
                        }
                    }
                    3 -> {
                        val list = obstacleY[y]?.toList()
                        if (list == null) {
                            x -= command
                        } else {
                            var index = list.lastIndex
                            while (index >= 0 && list[index] >= x) {
                                index--
                            }
                            if (index < 0) {
                                x -= command
                            } else {
                                if (x - list[index] > command) {
                                    x -= command
                                } else {
                                    x = list[index] + 1
                                }
                            }
                        }
                    }
                }
            }
        }
//        println("[$x,$y]")
        res = maxOf(res, x * x + y * y)
    }
    return res
}

fun main() {
    println(robotSim(intArrayOf(4, -1, 3), arrayOf()))
    println(robotSim(intArrayOf(4, -1, 4, -2, 4), arrayOf(intArrayOf(2, 4))))
    println(
        robotSim(
            intArrayOf(-2, -1, -2, 3, 7), arrayOf(
                intArrayOf(1, -3), intArrayOf(2, -3),
                intArrayOf(4, 0), intArrayOf(-2, 5),
                intArrayOf(-5, 2), intArrayOf(0, 0),
                intArrayOf(4, -4), intArrayOf(-2, -5),
                intArrayOf(-1, -2), intArrayOf(0, 2),
            )
        )
    )
    println(
        robotSim(
            intArrayOf(2, 2, 5, -1, -1), arrayOf(
                intArrayOf(-3, 5), intArrayOf(-2, 5),
                intArrayOf(3, 2), intArrayOf(5, 0),
                intArrayOf(-2, 0), intArrayOf(-1, 5),
                intArrayOf(5, -3), intArrayOf(0, 0),
                intArrayOf(-4, 4), intArrayOf(-3, 4),
            )
        )
    )
    println(
        robotSim(
            intArrayOf(8, -1, -1, -2, 8, -2, -1, -1, 8, -1, 8, -1, 8), arrayOf(
                intArrayOf(0, 3), intArrayOf(3, 2),
                intArrayOf(2, -1), intArrayOf(-1, 0),
            )
        )
    )
}