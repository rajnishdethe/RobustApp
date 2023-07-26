package com.example.robustapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PhoneActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var textViewFileName: TextView
    private lateinit var buttonBack: Button
    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonStop: Button

    // Array of media files (song resources)
    private val mediaFiles = arrayOf(
        R.raw.song1,
        R.raw.song2,
        R.raw.song3,
        R.raw.song4,
        R.raw.song5,
        R.raw.song6,
        R.raw.song7,
        R.raw.song8,
        R.raw.song9,
        R.raw.song10
        // Add more songs here if needed
    )

    // Current song index
    private var currentSongIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_activity)

        textViewFileName = findViewById(R.id.textViewFileName)
        buttonBack = findViewById(R.id.buttonBack) // Initialize the "Back" button
        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonNext = findViewById(R.id.buttonNext)
        buttonStop = findViewById(R.id.buttonStop)

        // Initialize media player with the first song
        mediaPlayer = MediaPlayer.create(this, mediaFiles[currentSongIndex])

        textViewFileName.text =
            "Media File: ${resources.getResourceEntryName(mediaFiles[currentSongIndex])}"

        buttonPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        buttonPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        buttonStop.setOnClickListener {
            mediaPlayer.apply {
                stop()
                prepare()
                seekTo(0)
            }
        }

        buttonNext.setOnClickListener {
            // Move to the next song when the "Next" button is clicked
            playNextSong()
        }

        buttonBack.setOnClickListener {
            // Move to the previous song when the "Back" button is clicked
            playPreviousSong()
        }

        // Set up a listener for when a song completes playing
        mediaPlayer.setOnCompletionListener {
            // Move to the next song when the current song finishes playing
            playNextSong()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun playNextSong() {
        // Increment the song index and check if it's within the array bounds
        currentSongIndex++
        if (currentSongIndex >= mediaFiles.size) {
            // Reset the index to loop back to the first song
            currentSongIndex = 0
        }

        // Release the current media player and create a new one with the next song
        mediaPlayer.release()
        mediaPlayer = MediaPlayer.create(this, mediaFiles[currentSongIndex])

        textViewFileName.text =
            "Media File: ${resources.getResourceEntryName(mediaFiles[currentSongIndex])}"

        // Start playing the next song automatically
        mediaPlayer.start()
    }

    private fun playPreviousSong() {
        // Decrement the song index and check if it's within the array bounds
        currentSongIndex--
        if (currentSongIndex < 0) {
            // Loop back to the last song in the array
            currentSongIndex = mediaFiles.size - 1
        }

        // Release the current media player and create a new one with the previous song
        mediaPlayer.release()
        mediaPlayer = MediaPlayer.create(this, mediaFiles[currentSongIndex])

        textViewFileName.text =
            "Media File: ${resources.getResourceEntryName(mediaFiles[currentSongIndex])}"

        // Start playing the previous song automatically
        mediaPlayer.start()
    }
}
