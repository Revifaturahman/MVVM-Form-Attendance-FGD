package com.example.mvvmformattendancefgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mvvmformattendancefgd.R
import com.example.mvvmformattendancefgd.databinding.FragmentOutputBinding
import com.example.mvvmformattendancefgd.viewmodel.AttadanceViewModel

class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    private val viewmodel : AttadanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewmodel.attedanceData.observe(viewLifecycleOwner){model ->
            binding.txtNamaResult.text = model.name
            binding.txtEmailResult.text = model.email
            binding.txtGenderResult.text = model.gender
            binding.txtTelefonResult.text = model.noTlp
            binding.txtSkillsetResult.text = model.skillSet.joinToString(", ")
            binding.txtKategoriResult.text = model.kategori
        }
        return binding.root
    }
}