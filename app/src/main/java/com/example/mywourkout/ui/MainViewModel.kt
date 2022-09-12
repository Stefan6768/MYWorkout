package com.example.mywourkout.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myworkout.data.model.Workout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

//import com.example.mywourkout.local.getDatabase
//import com.example.mywourkout.remote.AppRepository
//import com.example.mywourkout.remote.VideoApi

const val TAG = "MainViewModel"

//enum class ApiStatus

class MainViewModel (application: Application) : AndroidViewModel(application) {

 // private val database = getDatabase(application)
 // private val repository = AppRepository(VideoApi, database)

 // private val  _loading = MutableLiveData<ApiStatus>()
//  val loading: LiveData<ApiStatus>
//  get() = _loading


  // Kommunikationspunkt mit der FirebaseAuth
  private val firebaseAuth = FirebaseAuth.getInstance()

  private var _guest = false
  var guest: Boolean = false
    get() = _guest

  // currentuser ist null wenn niemand eingeloggt ist
  private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
  val currentUser: LiveData<FirebaseUser?>
  get() = _currentUser



  fun signup(email: String, password: String) {
    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
      if (it.isSuccessful) {
        login(email, password)
      } else {
        Log.e(TAG,"SignUp failed: ${it.exception}")
      }
    }
  }

  fun login(email: String, password: String) {
    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
      if (it.isSuccessful) {
              _currentUser.value = firebaseAuth.currentUser
        guest = false
      } else {
        Log.e(TAG,"Login failed: ${it.exception}")
      }
    }
  }
  fun anonymLogin() {
    firebaseAuth.signInAnonymously().addOnCompleteListener {
      if (it.isSuccessful) {
        _currentUser.value = firebaseAuth.currentUser
        guest = true
      } else {
        Log.e(TAG,"Anonym Login failed: ${it.exception}")
      }
    }
  }

  fun logout() {
    firebaseAuth.signOut()
    _currentUser.value = firebaseAuth.currentUser
  }

}