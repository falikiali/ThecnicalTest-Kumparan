package com.example.thecnicaltest_kumparan.utils

import com.example.thecnicaltest_kumparan.data.remote.responses.PostResponsesItem
import com.example.thecnicaltest_kumparan.data.remote.responses.UserResponsesItem
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
}