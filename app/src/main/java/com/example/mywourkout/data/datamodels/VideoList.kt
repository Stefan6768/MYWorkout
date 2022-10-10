package com.example.mywourkout.data.datamodels

class VideoList {


  private val _videos = loadMyworkout()
  val videos: List<Video>
    get() = _videos

  fun loadMyworkout(): List<Video> {
    return listOf(
      Video("Arm Training 5 min", "bfohE7qM9pM", "29"),
      Video("Arm Training 10 min", "kn1ylukKWG8", "30"),
      Video("Arm Training 15 min", "JfFV-mll0xU", "28"),
      Video("Bauch Training 5 min", "AOSaOtWtQfc", "27"),
      Video("Bauch Training 10 min", "X_ZJpZgRecI", "26"),
      Video("Bauch Training 15 min", "D7Bo3BqOCc4", "25"),
      Video("Bein Training 5 min", "XI4KlbpR7ks", "24"),
      Video("Bein Training 10 min", "bcH-qcnpy20", "23"),
      Video("Bein Training 15 min", "YPATBnaK-TA", "22"),
      Video("Cardio Training 5 min", "sHXxk2ek1g0", "21"),
      Video("Cardio Training 10 min", "ympgQ2GWWcY", "20"),
      Video("Cardio Training 15 min", "O9jWAf98-rU", "19"),
      Video("Ganz Körper Training 5 min", "kic4EeXOfNw", "18"),
      Video("Ganz Körper Training 10 min", "_B62uXgP7aM", "17"),
      Video("Ganz Körper Training 15 min", "A8AzJ9ODgmw", "16"),
      Video("Po Training 5 min", ">zXc9ea3gyyY", "15"),
      Video("Po Training 10 min", "jvizLLbre8s", "14"),
      Video("Po Training 15 min", "Y3VqVZ1mLCI", "13"),
      Video("Yoga Training 5 min", "2SyGLbXtS68<", "12"),
      Video("Yoga Training 10 min", "7Av1kR5TnIA", "11"),
      Video("Yoga Training 15 min", "dmlicWfwftA", "10"),
      Video("BOP Training 5 min", "yu5-uyQO1Mg", "9"),
      Video("BOP Training 10 min", "W8yVlnW0fZ4", "8"),
      Video("BOP Training 15 min", "2RRArWkRcPc", "7"),
      Video("Po Training 15 min", "Y3VqVZ1mLCI", "6"),
      Video("Yoga Training 5 min", "n_8MHciI9Ks<", "5"),
      Video("Yoga Training 10 min", "bcH-qcnpy20", "4"),
      Video("Yoga Training 15 min", "YPATBnaK-TA", "3"),
      Video("BOP Training 5 min", "XI4KlbpR7ks", "2"),
      Video("BOP Training 10 min", "bcH-qcnpy20", "1"),
      Video("BOP Training 15 min", "O9jWAf98-rU", "31")
    )
  }
}



