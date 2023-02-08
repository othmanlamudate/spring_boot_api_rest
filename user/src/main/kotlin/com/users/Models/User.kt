package com.users.Models


import jakarta.persistence.*


@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0
    @Column
    var email=""
    @Column
    var password=""
    @Column
    var nom=""
    @Column
    var prenom=""
    @Column
    var age=""
    @Column
    var image=""


}