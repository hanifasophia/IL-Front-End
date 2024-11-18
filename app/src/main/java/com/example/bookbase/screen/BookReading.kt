package com.example.bookbase.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookbase.data.DummyData
import com.example.bookbase.model.Book
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor

@Composable
fun BookReadingScreen(bookId: Int, navController: NavController) {
    val book = DummyData.books.find { it.id == bookId }
    val pages = book?.let { generatePages(it) } ?: listOf()
    var currentPage by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    if (book != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(BackgroundLight)
                .padding(16.dp)
        ) {
            Text(
                text = pages[currentPage],
                style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { if (currentPage > 0) currentPage-- },
                    enabled = currentPage > 0,
                    colors = ButtonDefaults.buttonColors(PrimaryColor)
                ) {
                    Text(text = "Previous", color = Color.White)
                }
                Button(
                    onClick = { if (currentPage < pages.lastIndex) currentPage++ },
                    enabled = currentPage < pages.lastIndex,
                    colors = ButtonDefaults.buttonColors(PrimaryColor)
                ) {
                    Text(text = "Next", color = Color.White)
                }
            }
        }
    }
}

fun generatePages(book: Book): List<String> {
    return listOf(
        """
        Page 1: A New Beginning
        The story of ${book.title} begins in a small, quiet town nestled between rolling hills and shimmering rivers. 
        The protagonist, with dreams as vast as the open sky, embarks on a journey that would change their life forever. 
        Each morning, the chirping of birds would remind them of the countless possibilities waiting beyond the horizon. 
        Yet, life in the town was not without challenges. The townsfolk were kind but cautious, and every step toward the unknown 
        brought with it a mix of excitement and apprehension. As the days passed, the protagonist began to realize that 
        greatness lies not in the absence of fear but in the courage to move forward despite it. 
        
        As days turned into weeks, the protagonist’s journey through the vast lands revealed not only the external beauty of 
        nature but also the inner strength required to endure the unknown. The hills whispered tales of old adventures, the rivers 
        carried the memories of countless voyagers, and the winds sang songs of hope. Every sunset was a reminder that the 
        end of one day marked the beginning of another. As the stars sparkled above, the protagonist made promises to themselves 
        to never stop chasing their dreams.

        This was the beginning of their story, and the first chapter of ${book.title}.
        The beauty of the small town was not just in its picturesque scenery but also in the simplicity of its everyday life. 
        The protagonist would often sit by the river, watching the gentle ripples dance under the golden rays of the sun. 
        They wondered about the lives of the people who once traveled these waters, their hopes, their dreams, and the 
        challenges they must have faced. It was a place that held secrets of the past and promises for the future.

        The town’s history was steeped in stories of resilience and adventure. The old library, a treasure trove of knowledge, 
        became a second home for the protagonist. They would lose themselves in the pages of books that spoke of distant lands, 
        brave explorers, and unimaginable treasures. Each story was a spark that fueled their own desire for exploration.

        On moonlit nights, the town seemed almost magical. The silver light bathed the hills, casting long shadows and 
        illuminating the path ahead. It was during these quiet moments that the protagonist felt most connected to their 
        dreams. They knew the journey ahead would not be easy, but they were ready to face whatever challenges came their way.

        ${book.title} begins with this sense of anticipation and wonder, setting the stage for an adventure that would leave 
        an indelible mark on their soul. And so, with a heart full of hope and a mind brimming with possibilities, the protagonist 
        took their first step into the unknown.
        """.trimIndent(),
        """
        Page 2: Trials and Triumphs
        As the journey unfolded, the protagonist encountered trials that tested their resolve. 
        The first was a storm that threatened to derail their path. With determination as their guide, 
        they pressed on, finding shelter in the most unexpected places and forging alliances with strangers 
        who would later become trusted companions. Along the way, they learned the value of perseverance 
        and the strength that comes from vulnerability. 
        
        Through treacherous forests and towering mountains, the protagonist faced challenges that would make even 
        the strongest falter. The harsh winter brought biting cold, the deep valleys echoed with the sounds of unseen dangers, 
        and the open plains offered no solace from the blazing sun. Yet, through it all, the protagonist held onto hope. 
        Companions they met along the way became sources of inspiration. Each shared stories of their own struggles and 
        victories, weaving a tapestry of shared humanity that bound them together.

        The journey through forests, mountains, and valleys was as much about self-discovery as it was about 
        reaching a destination. Each trial was a lesson, each triumph a milestone that brought them closer 
        to understanding their purpose. This chapter of ${book.title} teaches us that the greatest victories 
        are often born from the deepest struggles.
        Every challenge brought a sense of accomplishment, a small victory that pushed the protagonist further along their journey. 
        The nights were long and filled with reflection. In the quiet of the wilderness, with the fire crackling and the stars 
        as their only companions, they would think about their purpose, their dreams, and the people who mattered most in their lives. 
        These moments of solitude gave them clarity and strength.

        During one particularly grueling climb, when the icy winds cut through their clothes and the path seemed endless, 
        the protagonist encountered an elderly traveler. This stranger, despite their advanced age, was full of energy and optimism. 
        They shared stories of their own adventures, offering wisdom and encouragement that would stay with the protagonist for the 
        rest of their journey. It was a reminder that age was no barrier to dreams, and that experience was the greatest teacher.

        The protagonist’s journey was also marked by acts of kindness—small gestures from strangers that made a big difference. 
        A warm meal from a humble villager, a helping hand during a dangerous river crossing, or a simple smile that lifted their spirits. 
        These moments reinforced their belief in the goodness of humanity and the interconnectedness of all life.

        By the end of this chapter, the protagonist was no longer the same person who had started the journey. They had grown 
        in strength, wisdom, and compassion. ${book.title} reminds us that while the road may be difficult, it is these very 
        challenges that shape us into the people we are meant to be.
        """.trimIndent(),
        """
        Page 3: A Legacy Remembered
        The final chapter of ${book.title} is one of reflection and revelation. The protagonist, now wiser and 
        stronger, stands at the culmination of their journey. Looking back, they see not just the challenges 
        they overcame but the growth that came with each step. Their story is a testament to the power of dreams 
        and the unyielding spirit that drives us to pursue them. 
        As the protagonist gazed upon the horizon, they realized the journey was never about the destination alone—it 
        was about the moments in between. The laughter shared with strangers who became friends, the quiet nights 
        under a canopy of stars, and the courage to take one more step when their body begged them to stop. 
        These memories became the treasure of their journey.

        And on it goes, detailing every reflection, milestone, and legacy they left behind…
        """.trimIndent()
    )
}