package com.users.controllers

import com.users.Data.Data
import com.users.Models.User
import com.users.repositories.UsersRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @DeleteMapping("/delete")
    fun deleteUser(@RequestParam("id") id:Int){
        var d=Data(up)
        d.delete(id)
    }

    @PutMapping("/update")
    fun updateUser(id:Int,email:String,password:String,nom:String,prenom:String,age:String,image:String):Boolean{

        var d=Data(up)
        var ex=d.update(id,email,password,nom,prenom,age,image)
        if(ex){
            return true
        }
        return false
    }

}