package kz.chocofamily.coroutinelesson.presentation.fragments

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.presentation.MainActivity
import java.util.ArrayList

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-27
 */

internal const val DEEPLINK = "deeplink"

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNextInMain.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            findNavController().navigate(direction)
        }

        btnGeneratePush.setOnClickListener {
            val deeplink = etDeeplink.text.toString()
            val intent = Intent(activity?.applicationContext, MainActivity::class.java).apply {
                putExtra(DEEPLINK, deeplink)
            }
            val pendingIntent = PendingIntent.getActivity(requireContext(), (System.currentTimeMillis() and 0xfffffff).toInt(), intent, PendingIntent.FLAG_ONE_SHOT)
            val notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannelId = "rahmet_notifications"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannelName = "Rahmet notifications"
                val notificationChannel = NotificationChannel(
                    notificationChannelId,
                    notificationChannelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationManager.createNotificationChannel(notificationChannel)
                val notificationChannelGroups = ArrayList<NotificationChannelGroup>()
                val notificationInfoGroupId = "info_group"
                val notificationInfoGroupName = "Informational notifications"
                notificationChannelGroups.add(
                    NotificationChannelGroup(
                        notificationInfoGroupId,
                        notificationInfoGroupName
                    )
                )
                val notificationSystemGroupId = "system_group"
                val notificationSystemGroupName = "System notifications"
                notificationChannelGroups.add(
                    NotificationChannelGroup(
                        notificationSystemGroupId,
                        notificationSystemGroupName
                    )
                )
                notificationManager.createNotificationChannelGroups(notificationChannelGroups)
            }
            val builder = NotificationCompat.Builder(requireContext(), notificationChannelId)
                .setContentTitle("Проверка диплинка")
                .setContentText(deeplink)
                .setSmallIcon(R.drawable.ic_notifications)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
            intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
            notificationManager.notify(0, builder.build())
        }
    }
}