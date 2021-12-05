/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.userDataMS.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Getter
    @Setter
    @Id
    private String username;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String phone;
    
    @Getter
    @Setter
    private String economicActivity;
    
    @Getter
    @Setter
    private String occupation;
    
    @Getter
    @Setter
    private String role;

    @Getter
    @Setter
    private boolean state;

    @Getter
    @Setter
    private boolean account;

    @Getter
    @Setter
    private boolean forex;

    @Getter
    @Setter
    private String notwe;
}
