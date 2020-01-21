package com.petscape.server

import com.mongodb.client.MongoCollection

fun <T> MongoCollection<T>.toList(): List<T> {
    val list = mutableListOf<T>()
    find().forEach { list.add(it) }
    return list
}