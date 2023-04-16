package com.example.month7_lesson2.presentation.ui


import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.month7_lesson2.R
import com.example.month7_lesson2.databinding.FragmentEditNoteBinding
import com.example.month7_lesson2.domain.model.Note
import com.example.month7_lesson2.domain.usecase.CreateNoteUseCase
import com.example.month7_lesson2.presentation.ui.NoteFragment.Companion.UPDATE
import com.example.month7_lesson2.presentation.ui.base.BaseFragment
import com.example.month7_lesson2.presentation.utils.UIState
import com.example.month7_lesson2.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EditNoteFragment : BaseFragment(R.layout.fragment_edit_note) {
    private val binding by viewBinding(FragmentEditNoteBinding::bind)
    @Inject
    lateinit var createNoteUseCase: CreateNoteUseCase
    private val viewModel: EditNoteViewModel by viewModels()
    private lateinit var note: Note
    private var noteIsNull = true
    override fun setUPSubscriber() {
        super.setUPSubscriber()
        viewModel.editNoteState.collectUiState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                viewModel.loading.postValue(false)
            }
        )
        viewModel.createNoteState.collectUiState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                viewModel.loading.postValue(false)}
        )
    }

    override fun setUpRequest() {
        super.setUpRequest()
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible=it
        }
    }

    override fun setArguments() {
        super.setArguments()
        binding.sendBtn.setOnClickListener {
            if (arguments != null) {
                updateNote(note)
            } else {
                saveNote()
            }
            findNavController().navigateUp()
        }
    }

    private fun saveNote() {
        if (binding.etTitle.text.isNotEmpty() && binding.etDesc.text.isNotEmpty()) {
            if (noteIsNull) {
                viewModel.addNote(
                    Note(
                        title = binding.etTitle.text.toString(),
                        desc = binding.etDesc.text.toString()
                    )
                )
            }
        } else {
            showToast(getString(R.string.full))
        }
    }

    private fun updateNote(note: Note) {
        note.title = binding.etTitle.text.toString()
        note.desc = binding.etDesc.text.toString()
        viewModel.editNote(note)
    }

    override fun initialize() {
        super.initialize()
        if (arguments != null) {
            note = arguments?.getSerializable(UPDATE) as Note
            binding.etTitle.setText(note.title)
            binding.etDesc.setText(note.desc)
            binding.sendBtn.text = getString(R.string.edit)
            noteIsNull = false
        }
    }

}
