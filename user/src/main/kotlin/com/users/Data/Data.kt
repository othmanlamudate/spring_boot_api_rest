package com.users.Data

import com.users.Models.User
import com.users.repositories.UsersRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random
@Component
class Data(private val userRepository: UsersRepository):ApplicationRunner {

    public lateinit var n:String
    public lateinit var pr:String
    public lateinit var e:String
    public lateinit var p: String
    public lateinit var a:String

    override fun run(args: ApplicationArguments?) {



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
    fun delete(id:Int){
        this.userRepository.deleteById(id)
    }
    fun update(id:Int,email:String,password:String,nom:String,prenom:String,age:String,image:String):Boolean{

        if (this.userRepository.existsById(id)) {
            var user = this.userRepository.getReferenceById(id)
            user.id=id
            user.nom=nom
            user.prenom=prenom
            user.email=email
            user.password=password
            user.age= age
            user.image=image
            this.userRepository.save(user)
            return true
        }
        return false

    }
}