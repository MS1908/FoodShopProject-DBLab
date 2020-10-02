package com.food_shop.payload.others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailForm {

    private String receiverMail;

    private String header;

    private String content;
}
