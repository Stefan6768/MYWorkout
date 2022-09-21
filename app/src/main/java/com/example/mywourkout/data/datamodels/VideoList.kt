package com.example.mywourkout.data.datamodels

class VideoList {


    private val _videos = loadMyworkout()
    val videos: List<Video>
    get() = _videos

  fun loadMyworkout(): List<Video> {
    return listOf(
      Video("Arm Training 5 min", "bfohE7qM9pM"),
      Video("Arm Training 10 min", "kn1ylukKWG8"),
      Video("Arm Training 15 min", "JfFV-mll0xU"),
      Video("Bauch Training 5 min", "AOSaOtWtQfc"),
      Video("Bauch Training 10 min", "X_ZJpZgRecI"),
      Video("Bauch Training 15 min", "D7Bo3BqOCc4"),
      Video("Bein Training 5 min", "XI4KlbpR7ks"),
      Video("Bein Training 10 min", "bcH-qcnpy20"),
      Video("Bein Training 15 min", "YPATBnaK-TA"),
      Video("Cardio Training 5 min", "sHXxk2ek1g0"),
      Video("Cardio Training 10 min", "ympgQ2GWWcY"),
      Video("Cardio Training 15 min", "O9jWAf98-rU"),
      Video("Ganz Körper Training 5 min", "kic4EeXOfNw"),
      Video("Ganz Körper Training 10 min", "_B62uXgP7aM"),
      Video("Ganz Körper Training 15 min", "A8AzJ9ODgmw"),
      Video("Po Training 5 min", ">zXc9ea3gyyY"),
      Video("Po Training 10 min", "jvizLLbre8s"),
      Video("Po Training 15 min", "Y3VqVZ1mLCI"),
      Video("Youtube Videos 5 min", "n_8MHciI9Ks<"),
      Video("Youtube Video 10 min", "bcH-qcnpy20"),
      Video("Youtube Video 15 min", "YPATBnaK-TA"),
      Video("Training Video 5 min", "XI4KlbpR7ks"),
      Video("Training Video 10 min", "bcH-qcnpy20"),
      Video("Training Video 15 min", "O9jWAf98-rU")
    )
  }
}



