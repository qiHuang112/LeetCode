package leetcode

import java.util.*

/*
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户

示例:
Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-twitter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Twitter() {

    var time = 0
    val users = mutableMapOf<Int, User>()

    class NewsFeed(val id: Int, val time: Int)

    inner class User(val id: Int) {
        val following = mutableSetOf<Int>()
        val newsFeeds = mutableListOf<NewsFeed>()

        init {
            following.add(id)
        }

        fun post(tweetId: Int) {
            newsFeeds.add(NewsFeed(tweetId, time++))
        }

        fun get(): List<Int> {
            val queue = PriorityQueue<NewsFeed> { a, b -> b.time - a.time }
            for (id in following) {
                users[id]?.newsFeeds?.forEach {
                    queue.offer(it)
                }
            }
            val res = mutableListOf<Int>()
            while (queue.isNotEmpty() && res.size < 10) {
                res.add(queue.poll().id)
            }
            return res
        }

        fun follow(followeeId: Int) {
            following.add(followeeId)
        }

        fun unfollow(followeeId: Int) {
            if (followeeId != id) {
                following.remove(followeeId)
            }
        }

    }

    fun postTweet(userId: Int, tweetId: Int) {
        if (users[userId] == null) {
            users[userId] = User(userId)
        }
        users[userId]!!.post(tweetId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        if (users[userId] == null) {
            users[userId] = User(userId)
        }
        return users[userId]!!.get()
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (users[followerId] == null) {
            users[followerId] = User(followerId)
        }
        users[followerId]!!.follow(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (users[followerId] != null) {
            users[followerId]!!.unfollow(followeeId)
        }
    }

}

fun main() {
    Twitter().apply {
        postTweet(1, 5)
        getNewsFeed(1).let(::println)
        follow(1, 2)
        postTweet(2, 6)
        getNewsFeed(1).let(::println)
        unfollow(1, 2)
        getNewsFeed(1).let(::println)
    }
    println("*************")
    Twitter().apply {
        postTweet(1, 5)
        unfollow(1, 1)
        getNewsFeed(1).let(::println)
    }
}