package com.example.mvvmformattendancefgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.mvvmformattendancefgd.R
import com.example.mvvmformattendancefgd.databinding.FragmentInputBinding
import com.example.mvvmformattendancefgd.model.AttedanceModel
import com.example.mvvmformattendancefgd.viewmodel.AttadanceViewModel

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private val viewmodel: AttadanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentInputBinding.inflate(inflater, container, false)


//        Adapter
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.kategori_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spCategory.adapter = adapter
        }

//        Pengambilan value
        binding.btnSubmit.setOnClickListener {
        val model = AttedanceModel(
            name = binding.edtNama.text.toString(),
            noTlp = binding.edtTelefon.text.toString(),
            email = binding.edtEmail.text.toString(),
            gender = if(binding.radLakilaki.isChecked)  "laki-laki"  else  "Perempuan",
            kategori = binding.spCategory.selectedItem?.toString() ?: "Tidak Diketahui",
            skillSet = listOfNotNull(
                if (binding.chkAlgo.isChecked) "Algoritma" else null,
                if (binding.chkPrograming.isChecked) "Programming" else null,
                if (binding.chkDesignthinking.isChecked) "Design Thinking" else null,
                if (binding.chkCriticalthinking.isChecked) "Critical Thinking" else null,
                if (binding.chkProblemSolving.isChecked) "Problem Solving" else null
            )
        )

        viewmodel.setAttadance(model)
        parentFragmentManager.beginTransaction()
            .replace(R.id.frame_container, OutputFragment())
            .addToBackStack(null)
            .commit()
        }


        return binding.root
    }

}