package com.kimmandoo.project_exercise_3_2.feature4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModelProvider
import com.kimmandoo.project_exercise_3_2.MainActivity
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.FragmentAlertBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomBinding
import com.kimmandoo.project_exercise_3_2.feature2.FeatureTwoViewModel

class AlertFragment : Fragment() {

    private var _binding: FragmentAlertBinding? = null
    private val binding get() = _binding!!
    var notificationId = 45
    private val featureTwoViewModel by lazy { ViewModelProvider(this).get(FeatureTwoViewModel::class.java) }

    private val channelID = "app.todayspecial.noti1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = "알림 제목"
        val detail = "알림 내용"

//        val intent = Intent(context, AlertViewActivity::class.java).apply {
//            putExtra("title",title)
//            putExtra("detail",detail)
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//
//        val pendingIntent = PendingIntent.getActivity(context, 0,intent, PendingIntent.FLAG_MUTABLE)

// fullscreen 용 Activity Intent
        val fullscreenIntent = Intent(context, AlertViewActivity::class.java).apply {
            action = "fullscreen_activity"
            putExtra("title",title)
            putExtra("detail",detail)

            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val fullscreenPendingIntent = PendingIntent.getActivity(context, 0, fullscreenIntent, PendingIntent.FLAG_MUTABLE)
        val button = activity?.findViewById<Button>(R.id.btn_alert)
        var builder = NotificationCompat.Builder(requireContext(), channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setAutoCancel(true)
            .setContentText(detail)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setFullScreenIntent(fullscreenPendingIntent, true)
            .setContentIntent(fullscreenPendingIntent)

        binding.btnAlert.setOnClickListener {
            with(NotificationManagerCompat.from(requireContext())){
                createNotificationChannel()
                notify(notificationId, builder.build())
            }
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "today_special"
            val descriptionText = "today_special_description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}