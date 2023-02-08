package com.users.controllers

import com.users.Data.Data
import com.users.Models.User
import com.users.repositories.UsersRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserController(private val up:UsersRepository) {
    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(this.up.findAll())
    }

    @GetMapping("/search")
    fun getUserById(@RequestParam("s",defaultValue="") s:String):ResponseEntity<User>{
        return  ResponseEntity.ok(this.up.search(s))
    }


    @GetMapping("/singin")
    fun getUser(@RequestParam("E",defaultValue="") E:String,@RequestParam("P",defaultValue="") P:String):ResponseEntity<User>{
        return  ResponseEntity.ok(this.up.checkUser(E,P))
    }

    @GetMapping("/inscrit")
    fun addUser(@RequestParam("E",defaultValue="") E:String,@RequestParam("P",defaultValue="") P:String,
                @RequestParam("N",defaultValue="") N:String,@RequestParam("Pr",defaultValue="") Pr:String,
                @RequestParam("A",defaultValue="") A:String): ResponseEntity<Boolean>
    {
         var d=Data(up)
        d.n=N
        d.e=E
        d.p=P
        d.pr=Pr
        d.a=A

        d.add()



        return  ResponseEntity.ok(true)
    }
}