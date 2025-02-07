package com.example.cleanlogin.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.cleanlogin.BaseFragment
import com.example.cleanlogin.R
import com.example.cleanlogin.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment() : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){

//onCreate View----->? for save log in state management purpuse--->!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var user = FirebaseAuth.getInstance().currentUser

        Log.d("TAG", "onCreateView: ${user?.email} ")

        if (user != null) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            // findNavController().popBackStack()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }






    //onViewCreated--->?


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dontHaveAnAccount.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)

        }

        binding.loginBtn.setOnClickListener {

            var email = binding.editTextUserEmail.text.toString().trim()
            var password = binding.editTextPassword.text.toString().trim()

            userRegistration( email, password)
          //  findNavController().popBackStack()

        }
    }

    private fun userRegistration(email: String, password: String) {

        mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener {

            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)


        }.addOnFailureListener {

            var alertDialog = AlertDialog.Builder(requireActivity()).setTitle("Error")
                .setMessage(it.message)

            alertDialog.create().show()


        }


        }

}

