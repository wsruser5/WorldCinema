package com.example.worldcinema.data

data class EpisodesList(
    val description: String,
    val director: String,
    val episodeId: String,
    val images: List<String>,
    val moviesId: String,
    val name: String,
    val preview: String,
    val runtime: String,
    val stars: List<String>,
    val year: String
)

//{
//    "episodeId": "2",
//    "name": "Мы видимся только на свадьбах и похоронах",
//    "description": "В 1989 году одновременно рожают сорок три женщины, у которых до этого не было признаков беременности. Семь таких детей находит и усыновляет эксцентричный миллиардер Реджинальд Харгривз, который превращает их в команду супергероев. Спустя много лет его приёмные дети неохотно собираются в Академии «Амбрелла», чтобы похоронить отца.",
//    "moviesId": "1",
//    "director": "Питер Хоар",
//    "stars": [
//    "Эллен Пейдж",
//    "Том Хоппер",
//    "Дэвид Кастанеда",
//    "Эмми Рэйвер-Лампман"
//    ],
//    "year": "2019",
//    "runtime": "186",
//    "preview": "videoplayback.mp4",
//    "images": [
//    "the-umbrella-academy-first-reviews-696x442.jpg",
//    "the-umbrella-academy-season-2-five.jpg",
//    "umbrella-academy-screengrab-1-1550248953.jpg",
//    "the-umbrella-academy.jpeg"
//    ]
//},