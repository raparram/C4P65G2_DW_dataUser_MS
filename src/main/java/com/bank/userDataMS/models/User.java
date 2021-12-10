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
    private String address;

    @Getter
    @Setter
    private String phone;
        
    @Getter
    @Setter
    private String occupation;

    @Getter
    @Setter
    private boolean state;

}
