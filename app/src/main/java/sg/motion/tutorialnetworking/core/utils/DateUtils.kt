package sg.motion.tutorialnetworking.core.utils

import java.text.SimpleDateFormat
import java.util.Date

fun Date.getCurrentTimeStampWithFormat() : String {
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
    return currentDate
}