package edu.paggiluis.login.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import edu.paggiluis.login.databinding.FragmentDialogClientBinding

class ClientDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentDialogClientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogClientBinding.inflate(inflater, container, false)
        return binding.root
    }

}