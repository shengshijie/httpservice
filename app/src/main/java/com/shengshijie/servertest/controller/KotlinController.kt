package com.shengshijie.servertest.controller

import com.shengshijie.server.http.annotation.Controller
import com.shengshijie.server.http.annotation.Param
import com.shengshijie.server.http.annotation.RequestMapping
import com.shengshijie.server.http.exception.BusinessException
import com.shengshijie.server.http.response.ByteArrayResponse
import com.shengshijie.server.http.response.SerializedResponse
import com.shengshijie.servertest.App
import com.shengshijie.servertest.Person
import com.shengshijie.servertest.loadAssets

@Controller
@RequestMapping(value = "/kotlin")
class KotlinController {
    @RequestMapping(value = "/post1", method = "POST")
    fun post1(@Param(value = "amount", required = false, defaultValue = "12") amount: String, name: String, age: String): Any {
        return "$amount|$name|$age"
    }

    @RequestMapping(value = "/post2", method = "POST")
    fun post2() {
        throw BusinessException("dingdan", 205)
    }

    @RequestMapping(value = "/get1", method = "GET")
    fun get1(amount: String): Any {
        return SerializedResponse(Person(null, "34"))
    }

    @RequestMapping(value = "/get2", method = "GET")
    fun get2(): Any {
        val content = loadAssets(App.instance, "index.html")
        return ByteArrayResponse("text/html", content)
    }

    @RequestMapping(value = "/favicon.ico", method = "GET")
    fun favicon(): Any {
        val content = loadAssets(App.instance, "favicon.ico")
        return ByteArrayResponse("text/html", content)
    }

}