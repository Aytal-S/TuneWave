package com.allenhouse.mini_project

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allenhouse.mini_project.databinding.FragmentFavoritesBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class favorites : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Gehra.setOnClickListener { playSong(R.raw.gehrahuadhurandhar) }
        binding.palpal.setOnClickListener { playSong(R.raw.palpal) }
        binding.shaky.setOnClickListener { playSong(R.raw.shaky) }
        binding.humpyar.setOnClickListener { playSong(R.raw.humpyaarkarnewale) }
        binding.chandmera.setOnClickListener { playSong(R.raw.chandmeradil) }
        binding.ajkiraat.setOnClickListener { playSong(R.raw.aajkiraat) }
        binding.dilkepass.setOnClickListener { playSong(R.raw.palpaldilkepaas) }
    }

    private fun playSong(resId: Int) {
        // Stop and release previous mediaPlayer if it's still playing
        mediaPlayer?.stop()
        mediaPlayer?.release()

        mediaPlayer = MediaPlayer.create(requireContext(), resId)
        mediaPlayer?.start()

        // Release resources when the song finishes
        mediaPlayer?.setOnCompletionListener { mp ->
            mp.release()
            if (mediaPlayer == mp) {
                mediaPlayer = null
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
        mediaPlayer = null
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            favorites().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
