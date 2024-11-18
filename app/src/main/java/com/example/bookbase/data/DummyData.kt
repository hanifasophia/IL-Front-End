package com.example.bookbase.data

import com.example.bookbase.R
import com.example.bookbase.model.Author
import com.example.bookbase.model.Book


object DummyData {
    val authors = listOf(
        // Indonesian Authors
        Author(
            id = 1,
            name = "Ahmad Tohari",
            photoResId = R.drawable.ahmad_tohari,
            biography = "Ahmad Tohari is an Indonesian author famous for the novel Ronggeng Dukuh Paruk, a story about tradition and life's struggles.",
            numberOfBooks = 2,
            activeYears = "1975 - Present",
            notableWorks = listOf("Ronggeng Dukuh Paruk", "Bekisar Merah"),
            books = listOf(1, 5)
        ),
        Author(
            id = 2,
            name = "Dewi Lestari",
            photoResId = R.drawable.dewi_lestari,
            biography = "Dewi Lestari, also known as Dee, is an Indonesian author known for the Supernova series and other inspirational works.",
            numberOfBooks = 2,
            activeYears = "2001 - Present",
            notableWorks = listOf("Supernova", "Perahu Kertas"),
            books = listOf(4, 10)
        ),
        Author(
            id = 3,
            name = "Pramoedya A.T",
            photoResId = R.drawable.pramoedya_ananta_toer,
            biography = "Pramoedya is one of Indonesia's greatest writers, known for his works that depict Indonesian society.",
            numberOfBooks = 1,
            activeYears = "1940 - 2006",
            notableWorks = listOf("Bumi Manusia"),
            books = listOf(3)
        ),
        Author(
            id = 4,
            name = "Andrea Hirata",
            photoResId = R.drawable.andrea_hirata,
            biography = "Andrea Hirata is an Indonesian author known for his novel Laskar Pelangi, which has inspired many people.",
            numberOfBooks = 1,
            activeYears = "2005 - Present",
            notableWorks = listOf("Laskar Pelangi"),
            books = listOf(2)
        ),

        // International Authors
        Author(
            id = 5,
            name = "Haruki Murakami",
            photoResId = R.drawable.haruki_murakami,
            biography = "Haruki Murakami is a Japanese author known for his surreal style and introspective narratives.",
            numberOfBooks = 2,
            activeYears = "1979 - Present",
            notableWorks = listOf("Norwegian Wood", "Kafka on the Shore"),
            books = listOf(8, 12)
        ),
        Author(
            id = 6,
            name = "J.K. Rowling",
            photoResId = R.drawable.jk_rowling,
            biography = "An English author famous for the Harry Potter series, one of the most popular book series of all time.",
            numberOfBooks = 2,
            activeYears = "1997 - Present",
            notableWorks = listOf("Harry Potter", "Fantastic Beasts"),
            books = listOf(6, 11)
        ),
        Author(
            id = 7,
            name = "George R.R. Martin",
            photoResId = R.drawable.george_rr_martin,
            biography = "An American author known for the A Song of Ice and Fire series, the basis for the Game of Thrones TV series.",
            numberOfBooks = 2,
            activeYears = "1970 - Present",
            notableWorks = listOf("Game of Thrones", "A Clash of Kings"),
            books = listOf(7, 13)
        ),
        Author(
            id = 8,
            name = "Stephen King",
            photoResId = R.drawable.stephen_king,
            biography = "An American author famous for horror, thriller, and supernatural fiction.",
            numberOfBooks = 2,
            activeYears = "1974 - Present",
            notableWorks = listOf("The Shining", "IT"),
            books = listOf(9, 14)
        ),
        Author(
            id = 9,
            name = "Agatha Christie",
            photoResId = R.drawable.agatha_christie,
            biography = "An English author known as the 'Queen of Crime' for her legendary mystery novels.",
            numberOfBooks = 1,
            activeYears = "1920 - 1976",
            notableWorks = listOf("Murder on the Orient Express"),
            books = listOf(15)
        )
    )

    val books = mutableListOf(
        // Books by Indonesian Authors
        Book(
            id = 1,
            title = "Ronggeng Dukuh Paruk",
            genre = listOf("Drama", "Tradition"),
            pageCount = 288,
            coverResId = R.drawable.ronggeng_dukuh_paruk,
            synopsis = "The tragic story of Srintil, a ronggeng dancer, who becomes the embodiment of tradition in Dukuh Paruk village. This novel delves into the simple yet tumultuous life of the village, exploring themes of betrayal, love, and survival amidst societal changes. Srintil, chosen as the bearer of the ronggeng legacy, faces numerous trials, from heartbreak and treachery to an identity crisis. It’s a profound tale of life, freedom, and sacrifice.",
            releaseYear = 1982,
            rating = 4.6f,
            authorName = "Ahmad Tohari"
        ),
        Book(
            id = 2,
            title = "Laskar Pelangi",
            genre = listOf("Fiction", "Inspiration"),
            pageCount = 529,
            coverResId = R.drawable.laskar_pelangi,
            synopsis = "This inspiring story follows a group of ten children from the impoverished island of Belitung as they fight for their education and a brighter future. Despite their humble backgrounds and limited resources, their determination, dreams, and unbreakable spirit shine through. Through the eyes of Ikal, the narrator, we witness the power of friendship, hope, and resilience in transforming lives and breaking barriers.",
            releaseYear = 2005,
            rating = 4.7f,
            authorName = "Andrea Hirata"
        ),
        Book(
            id = 3,
            title = "Bumi Manusia",
            genre = listOf("History", "Romance"),
            pageCount = 535,
            coverResId = R.drawable.bumi_manusia,
            synopsis = "An epic tale that portrays the struggles of Indonesian society during the colonial era. The story revolves around Minke, a native boy who dares to challenge societal norms and pursue justice and love in a time of oppression. With vivid depictions of culture, politics, and personal relationships, this novel captures the essence of a nation's fight for identity and independence.",
            releaseYear = 1980,
            rating = 4.8f,
            authorName = "Pramoedya Ananta Toer"
        ),
        Book(
            id = 4,
            title = "Supernova",
            genre = listOf("Science Fiction", "Philosophy"),
            pageCount = 320,
            coverResId = R.drawable.supernova,
            synopsis = "A thought-provoking story that intertwines science, spirituality, and philosophy. This novel follows the lives of diverse characters whose paths cross in unexpected ways, exploring deep existential questions about humanity, purpose, and the universe. With its unique narrative style and layered storytelling, 'Supernova' challenges readers to think beyond the ordinary.",
            releaseYear = 2001,
            rating = 4.5f,
            authorName = "Dewi Lestari"
        ),
        Book(
            id = 5,
            title = "Bekisar Merah",
            genre = listOf("Drama", "Culture"),
            pageCount = 300,
            coverResId = R.drawable.bekisar_merah,
            synopsis = "A poignant tale of Lasi, a young girl from a rural village, as she navigates the complexities of identity, survival, and societal expectations. Caught between traditional values and modern desires, Lasi's journey is one of resilience and self-discovery. The novel paints a vivid picture of cultural transitions and the challenges of finding one's place in a changing world.",
            releaseYear = 1985,
            rating = 4.3f,
            authorName = "Ahmad Tohari"
        ),
        Book(
            id = 6,
            title = "Perahu Kertas",
            genre = listOf("Romance", "Drama"),
            pageCount = 400,
            coverResId = R.drawable.perahu_kertas,
            synopsis = "A heartfelt love story that explores the dreams, aspirations, and struggles of young people as they navigate the complexities of life and relationships. Keenan and Kugy, two individuals with distinct personalities and ambitions, find their lives intertwined in a journey of love, passion, and self-discovery. The story captures the bittersweet essence of growing up and chasing dreams.",
            releaseYear = 2009,
            rating = 4.4f,
            authorName = "Dewi Lestari"
        ),

        // Books by International Authors
        Book(
            id = 7,
            title = "Game of Thrones",
            genre = listOf("Fantasy", "Drama"),
            pageCount = 694,
            coverResId = R.drawable.game_of_thrones,
            synopsis = "A gripping tale of power, betrayal, and the relentless fight for the Iron Throne. Set in the fictional continents of Westeros and Essos, the story weaves together the lives of noble families as they vie for control, facing battles, alliances, and betrayals. With complex characters and an intricate plot, this epic fantasy redefines the genre with its realism and moral ambiguity.",
            releaseYear = 1996,
            rating = 4.9f,
            authorName = "George R.R. Martin"
        ),
        Book(
            id = 8,
            title = "Norwegian Wood",
            genre = listOf("Romance", "Drama"),
            pageCount = 296,
            coverResId = R.drawable.norwegian_wood,
            synopsis = "A nostalgic and deeply emotional story of love, loss, and coming of age. Toru Watanabe reflects on his youth, recalling the relationships that shaped him during his college years. The novel explores themes of mental health, friendship, and the impact of choices, set against the backdrop of 1960s Tokyo.",
            releaseYear = 1987,
            rating = 4.8f,
            authorName = "Haruki Murakami"
        ),
        Book(
            id = 9,
            title = "The Shining",
            genre = listOf("Horror", "Thriller"),
            pageCount = 447,
            coverResId = R.drawable.the_shining,
            synopsis = "A spine-chilling tale of the Torrance family, who move into the Overlook Hotel for the winter. As isolation takes its toll, Jack Torrance succumbs to the hotel's malevolent influence, putting his wife Wendy and son Danny in grave danger. With its atmospheric setting and psychological depth, this novel is a masterpiece of horror and suspense.",
            releaseYear = 1977,
            rating = 4.7f,
            authorName = "Stephen King"
        ),
        Book(
            id = 10,
            title = "Kafka on the Shore",
            genre = listOf("Fiction", "Fantasy"),
            pageCount = 505,
            coverResId = R.drawable.kafka_on_the_shore,
            synopsis = "A surreal and magical journey of two characters, Kafka Tamura and Nakata, whose fates are intertwined in mysterious ways. Combining elements of Japanese folklore, metaphysics, and dreams, this novel explores themes of identity, memory, and destiny, offering a unique narrative that blurs the line between reality and fantasy.",
            releaseYear = 2002,
            rating = 4.6f,
            authorName = "Haruki Murakami"
        ),
        Book(
            id = 11,
            title = "Harry Potter and the Sorcerer's Stone",
            genre = listOf("Fantasy", "Adventure"),
            pageCount = 309,
            coverResId = R.drawable.harry_potter,
            synopsis = "The magical story of Harry Potter, a young boy who discovers he is a wizard on his eleventh birthday. Harry is whisked away to Hogwarts School of Witchcraft and Wizardry, where he makes lifelong friends, uncovers the truth about his parents' mysterious deaths, and faces the dark wizard Lord Voldemort. This enchanting tale marks the beginning of a legendary series filled with magic, friendship, and courage.",
            releaseYear = 1997,
            rating = 4.9f,
            authorName = "J.K. Rowling"
        ),
        Book(
            id = 12,
            title = "Fantastic Beasts and Where to Find Them",
            genre = listOf("Fantasy", "Adventure"),
            pageCount = 128,
            coverResId = R.drawable.fantastic_beasts,
            synopsis = "A whimsical guide to the magical creatures that inhabit the wizarding world. Written as a textbook by the famous magizoologist Newt Scamander, this book offers a fascinating glimpse into the creatures that Harry Potter and his friends encounter throughout their adventures. Packed with humor, creativity, and insight, it’s a must-read for any fan of the magical universe.",
            releaseYear = 2001,
            rating = 4.5f,
            authorName = "J.K. Rowling"
        ),
        Book(
            id = 13,
            title = "A Clash of Kings",
            genre = listOf("Fantasy", "Adventure"),
            pageCount = 768,
            coverResId = R.drawable.a_clash_of_kings,
            synopsis = "The second installment of the 'A Song of Ice and Fire' series, this book continues the gripping saga of Westeros as the battle for the Iron Throne intensifies. With the kingdom divided, various factions rise to claim power, while looming threats beyond the Wall threaten to upend everything. Rich with political intrigue, war, and unforgettable characters, this epic fantasy expands on the world introduced in 'Game of Thrones.'",
            releaseYear = 1998,
            rating = 4.8f,
            authorName = "George R.R. Martin"
        ),
        Book(
            id = 14,
            title = "IT",
            genre = listOf("Horror", "Thriller"),
            pageCount = 1138,
            coverResId = R.drawable.it,
            synopsis = "A terrifying tale of a group of children in Derry, Maine, who confront an ancient, shape-shifting evil that preys on the town's residents. Known simply as 'IT,' this entity often takes the form of a menacing clown named Pennywise. Spanning decades, the story explores the power of friendship, the trauma of childhood, and the resilience needed to face one's deepest fears.",
            releaseYear = 1986,
            rating = 4.8f,
            authorName = "Stephen King"
        ),
        Book(
            id = 15,
            title = "Murder on the Orient Express",
            genre = listOf("Mystery", "Crime"),
            pageCount = 256,
            coverResId = R.drawable.murder_on_the_orient_express,
            synopsis = "A classic mystery featuring the brilliant detective Hercule Poirot. While aboard the luxurious Orient Express, a wealthy American is found murdered in his compartment. With the train stalled by a snowdrift, Poirot investigates the eclectic group of passengers, uncovering secrets and motives in a thrilling race to identify the killer before they strike again. A masterpiece of suspense and deduction.",
            releaseYear = 1934,
            rating = 4.9f,
            authorName = "Agatha Christie"
        )
    )
}
