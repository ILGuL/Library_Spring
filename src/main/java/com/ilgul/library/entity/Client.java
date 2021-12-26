package com.ilgul.library.entity;

import com.ilgul.library.dto.ClientDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<BookInUse> bookInUses = new ArrayList<>();

    public Client(ClientDto dto){
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        email = dto.getEmail();
        phone = dto.getPhone();
    }
}
