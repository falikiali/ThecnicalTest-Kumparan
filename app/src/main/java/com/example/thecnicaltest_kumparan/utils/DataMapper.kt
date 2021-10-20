package com.example.thecnicaltest_kumparan.utils

import com.example.thecnicaltest_kumparan.data.remote.responses.*
import com.example.thecnicaltest_kumparan.domain.model.*

object DataMapper {
    fun mapPostResponseToEntities(input: List<PostResponseItem>): List<Post> {
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

    fun mapUsersResponseToEntities(input: List<UserResponseItem>): List<User> {
        val listUser = ArrayList<User>()
        input.map {
            val user = User(
                it.email,
                it.id,
                it.name,
                it.company.name,
                it.address.street + ", " + it.address.suite + ", " + it.address.city + ", " + it.address.zipcode,
                it.phone,
                it.website
            )
            listUser.add(user)
        }
        return listUser
    }

    fun mapUserResponseToEntities(input: UserResponseItem): User =
        User(
            input.email,
            input.id,
            input.name,
            input.company.name,
            input.address.street + ", " + input.address.suite + ", " + input.address.city + ", " + input.address.zipcode,
            input.phone,
            input.website
        )

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

    fun mapAlbumResponseToEntities(input: List<AlbumResponseItem>): List<Album> {
        val listAlbum = ArrayList<Album>()
        input.map {
            val album = Album(
                it.id,
                it.title,
                it.userId
            )
            listAlbum.add(album)
        }
        return listAlbum
    }

    fun mapPhotoResponseToEntities(input: List<PhotoResponseItem>): List<Photo> {
        val listPhoto = ArrayList<Photo>()
        input.map {
            val photo = Photo(
                it.albumId,
                it.id,
                it.thumbnailUrl,
                it.title,
                it.url
            )
            listPhoto.add(photo)
        }
        return listPhoto
    }
}