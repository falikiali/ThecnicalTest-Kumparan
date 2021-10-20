package com.example.thecnicaltest_kumparan.utils

import com.example.thecnicaltest_kumparan.data.remote.responses.CommentResponseItem
import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
import com.example.thecnicaltest_kumparan.domain.model.Comment
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

object DataMapper {
    fun mapPostResponseToEntities(input: List<PostResponsesItem>): List<Post> {
        val listPost = ArrayList<Post>()
        input.map {
            val post = Post(
                it.body,
                it.id,
                it.title,
                it.userId
            )
            listPost.add(post)
        }
        return listPost
    }

    fun mapUserResponseToEntities(input: List<UserResponsesItem>): List<User> {
        val listUser = ArrayList<User>()
        input.map {
            val user = User(
                it.email,
                it.id,
                it.name,
                it.company.name
            )
            listUser.add(user)
        }
        return listUser
    }

    fun mapCommentResponseToEntities(input: List<CommentResponseItem>): List<Comment> {
        val listComment = ArrayList<Comment>()
        input.map {
            val comment = Comment(
                it.body,
                it.email,
                it.id,
                it.name,
                it.postId
            )
            listComment.add(comment)
        }
        return listComment
    }
}