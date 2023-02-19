package com.users.repositories

import com.users.Models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsersRepository:JpaRepository<User,Int> {
  @Query("select * from user where id = ?",nativeQuery=true)
  fun search(s:String):User

  @Query("select * from user where email = ? and password = ?",nativeQuery=true)
  fun checkUser(e: String, p: String): User

  @Modifying
  @Query("DELETE FROM user  WHERE id=?", nativeQuery = true)
  fun deleteUser(id:Long):Int

}