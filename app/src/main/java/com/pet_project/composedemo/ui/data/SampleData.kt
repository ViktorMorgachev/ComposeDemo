package com.pet_project.composedemo.ui.data

import com.pet_project.composedemo.R

val sampleConversation by lazy {
    listOf(
        Message(
            "Anastasia",
            "Всем привет",
            sampleUsers.firstOrNull() { it.name ==  "Anastasia"}!!.photoID
        ),
        Message(
            name = "Olga",
            "Привет\n" +
                "Как у вас в целом дела по проекту?\n" +
                "И в целом? \n" +
                "Я тут нашла немного полезной информации\n" +
                "Но она в основном про железо и айти\n" +
                "Кто хочет получить ссылку на неё\n",
            sampleUsers.firstOrNull() { it.name ==  "Olga"}!!.photoID
        ),
        Message(
            "Anastasia",
            "У меня всё так же, по немногу, ты как?\n" +
                "Нужно у Виктора спросить\n Скидывый информацию, гляну",
            sampleUsers.firstOrNull() { it.name ==  "Anastasia"}!!.photoID
        ),
        Message(
            "Olga",
            "Ок, сейчас найду, я норм\n На пару минут отойду",
            sampleUsers.firstOrNull() { it.name ==  "Olga"}!!.photoID
        ),
        Message(
            "Brother",
            "Привет девченки, неплохо тут у вас\n" +
                "случайно чат нашёл.....",
            sampleUsers.firstOrNull() { it.name ==  "Brother"}!!.photoID
        ),
        Message(
            "Brother",
            "Чет Витька не видно, не ужели смылся?: )",
            sampleUsers.firstOrNull() { it.name ==  "Brother"}!!.photoID
        ),
        Message(
            "Anastasia",
            "Ты кто? И что тут делаешь? Сейчас Виктору напишу!\nМы вообще-то проект обсуждаем!",
            sampleUsers.firstOrNull() { it.name == "Anastasia"}!!.photoID
        ),
        Message(
            "Olga",
            "Действительно что тут происходит",
            sampleUsers.firstOrNull() { it.name ==  "Olga"}!!.photoID
        ),
        Message(
            "Brother",
            "Сорян дамы, забыл представится, Меня Иван зовут :)",
            sampleUsers.firstOrNull() { it.name ==  "Brother"}!!.photoID
        ),
        Message(
            "Olga",
            "Настя, пожалуйста кикни его из чата, как он сюда попал???",
            sampleUsers.firstOrNull() { it.name ==  "Olga"}!!.photoID
        ),
        Message(
            "Brother",
            "Полегче девчёнки, я тут с миром,\n не сделаю ничего такого вам плохого",
            sampleUsers.firstOrNull() { it.name ==  "Brother"}!!.photoID
        ),
        Message(
            "Olga",
            "Блин, где же Виктор.....",
            sampleUsers.firstOrNull() { it.name ==  "Olga"}!!.photoID
        ),
        Message(
            "Anastasia",
            "Я ему написала но он чёт удалил моё сообщение!!! ",
            sampleUsers.firstOrNull() { it.name ==  "Anastasia"}!!.photoID
        ),
    )
}

val sampleUsers = listOf(
    User(name = "Anastasia", photoID = R.drawable.anastasia, age = 20, phoneNumber = "79995753220"),
    User(name = "Olga", photoID = R.drawable.olga, age = 23, phoneNumber = "79912087747"),
    User(name = "Brother", photoID = R.drawable.brother, age = 30, phoneNumber = "78959276370"),
    User(name = "Elizabet", photoID = R.drawable.elizabet, age = 15, phoneNumber = "79877854748")
)
