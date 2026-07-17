package com.allenhouse.mini_project

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allenhouse.mini_project.databinding.FragmentHomeBinding

class home : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("param1")
            param2 = it.getString("param2")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("userName", "Guest")
        binding.name.text = name

        binding.Kesar.setOnClickListener {
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()
            
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.kesariya)
            mediaPlayer?.start()

            // Release resources when the song finishes
            mediaPlayer?.setOnCompletionListener { mp ->
                mp.release()
                mediaPlayer = null
            }
        }
        binding.Gehra.setOnClickListener {
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.gehrahuadhurandhar)
            mediaPlayer?.start()

        }

        binding.palpal.setOnClickListener {
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.palpal)
            mediaPlayer?.start()

        }

        binding.shaky.setOnClickListener {
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.shaky)
            mediaPlayer?.start()
        }
        binding.humpyar.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.humpyaarkarnewale)
            mediaPlayer?.start()
        }
        binding.orkyachiyee.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.arijitsong)
            mediaPlayer?.start()
        }
        binding.pardesiya.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.pardesiya)
            mediaPlayer?.start()

        }

        binding.jhol2.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.jhol2)
            mediaPlayer?.start()

        }
        binding.ajkiraat.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.aajkiraat)
            mediaPlayer?.start()
        }

        binding.dilkepass.setOnClickListener{
            // Stop and release previous mediaPlayer if it's still playing
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.palpaldilkepaas)
            mediaPlayer?.start()
        }
        binding.chandmera.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.chandmeradil)
            mediaPlayer?.start()
        }
        binding.kyahua.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.kyahuaterawada)
            mediaPlayer?.start()
        }
        binding.yehraate.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.yehraateyehmausa)
            mediaPlayer?.start()
        }
        binding.ekladki.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.ekladkibheegi)
            mediaPlayer?.start()
        }
        binding.pyarkanagma.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.pyarkanagma)
            mediaPlayer?.start()
        }
        binding.khasiyat.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer= MediaPlayer.create(requireContext(),R.raw.khasiyat)
            mediaPlayer?.start()
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
            home().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}