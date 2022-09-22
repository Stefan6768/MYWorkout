package com.example.mywourkout.ui

import android.app.Application
import android.security.identity.AccessControlProfileId
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mywourkout.data.datamodels.User
import com.example.mywourkout.data.datamodels.Video
import com.example.mywourkout.data.datamodels.VideoList
import com.example.mywourkout.local.RepositoryUser
import com.example.mywourkout.local.getDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

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

  private val database = getDatabase(application)
  private val repositoryUser = RepositoryUser(database)

  val userList = repositoryUser.userList

  private val _complete = MutableLiveData<Boolean>()
  val complete: LiveData<Boolean>
  get() = _complete

  fun insertUser(user: User) {
    viewModelScope.launch {
      repositoryUser.insert(user)
      _complete.value = true
    }
  }

  fun updateUser(user: User) {
    viewModelScope.launch {
      repositoryUser.update(user)
      _complete.value = true
    }
  }

  fun deleteUser(id: Long) {
    viewModelScope.launch {
      repositoryUser.delete(id)
      _complete.value = true
    }
  }

  fun unsetComplete() {
    _complete.value = false
  }



  private val videolist = VideoList()

  private var _videos: List<Video> = videolist.videos
  val videos: List<Video>
    get() = _videos



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