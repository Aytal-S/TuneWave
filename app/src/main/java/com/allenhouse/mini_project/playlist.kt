package com.allenhouse.mini_project

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allenhouse.mini_project.databinding.FragmentPlaylistBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class playlist : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentPlaylistBinding? = null
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
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Kesar.setOnClickListener { playSong(R.raw.kesariya) }
        binding.Gehra.setOnClickListener { playSong(R.raw.gehrahuadhurandhar) }
        binding.palpal.setOnClickListener { playSong(R.raw.palpal) }
        binding.pardesiya.setOnClickListener { playSong(R.raw.pardesiya) }
        binding.khsiyat.setOnClickListener { playSong(R.raw.khasiyat) }
        binding.chandmera.setOnClickListener { playSong(R.raw.chandmeradil) }
        binding.jhol2.setOnClickListener { playSong(R.raw.jhol2) }

    }

    private fun playSong(resId: Int) {
        // Stop and release any existing media player to avoid overlapping audio
        mediaPlayer?.stop()
        mediaPlayer?.release()

        mediaPlayer = MediaPlayer.create(requireContext(), resId)
        mediaPlayer?.start()

        // Automatically release resources when the song finishes
        mediaPlayer?.setOnCompletionListener { mp ->
            mp.release()
            if (mediaPlayer == mp) {
                mediaPlayer = null
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Release the media player and nullify binding when the fragment is destroyed
        mediaPlayer?.release()
        mediaPlayer = null
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            playlist().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
