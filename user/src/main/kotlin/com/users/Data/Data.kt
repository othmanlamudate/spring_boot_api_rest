package com.users.Data

import com.users.Models.User
import com.users.repositories.UsersRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random
@Component
class Data(private val userRepository: UsersRepository):ApplicationRunner {
    public var active: Boolean=false
    public lateinit var n:String
    public lateinit var pr:String
    public lateinit var e:String
    public lateinit var p: String
    public lateinit var a:String

    override fun run(args: ApplicationArguments?) {
        if(active==true){
            this.add()
        }

    }
    fun add(){
        val user= User()
        user.nom= n
        user.prenom=pr
        user.email=e
        user.password=p
        user.age= a
        user.image="http://lorenpixel.com/200/200?"+ Random.nextInt(10000)
        this.userRepository.save(user)
    }
}