package com.example.gramaangana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainDashboard(
                onLogout = {

                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDashboard(
    onLogout: () -> Unit
) {

    var currentScreen by remember {
        mutableStateOf("home")
    }

    var darkMode by remember {
        mutableStateOf(false)
    }

    MaterialTheme(
        colorScheme =
            if (darkMode)
                darkColorScheme()
            else
                lightColorScheme()
    ) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {
                        Text("Grama Angana")
                    },

                    actions = {

                        Switch(
                            checked = darkMode,

                            onCheckedChange = {
                                darkMode = it
                            }
                        )

                        TextButton(
                            onClick = {
                                onLogout()
                            }
                        ) {
                            Text("Logout")
                        }
                    }
                )
            },

            bottomBar = {

                NavigationBar {

                    NavigationBarItem(
                        selected = currentScreen == "home",

                        onClick = {
                            currentScreen = "home"
                        },

                        icon = {
                            Icon(Icons.Default.Home, null)
                        },

                        label = {
                            Text("Home")
                        }
                    )

                    NavigationBarItem(
                        selected = currentScreen == "events",

                        onClick = {
                            currentScreen = "events"
                        },

                        icon = {
                            Icon(Icons.Default.DateRange, null)
                        },

                        label = {
                            Text("Events")
                        }
                    )

                    NavigationBarItem(
                        selected = currentScreen == "notices",

                        onClick = {
                            currentScreen = "notices"
                        },

                        icon = {
                            Icon(Icons.Default.Notifications, null)
                        },

                        label = {
                            Text("Notices")
                        }
                    )

                    NavigationBarItem(
                        selected = currentScreen == "maintenance",

                        onClick = {
                            currentScreen = "maintenance"
                        },

                        icon = {
                            Icon(Icons.Default.Build, null)
                        },

                        label = {
                            Text("Maintenance")
                        }
                    )

                    NavigationBarItem(
                        selected = currentScreen == "profile",

                        onClick = {
                            currentScreen = "profile"
                        },

                        icon = {
                            Icon(Icons.Default.Person, null)
                        },

                        label = {
                            Text("Profile")
                        }
                    )

                    NavigationBarItem(
                        selected = currentScreen == "admin",

                        onClick = {
                            currentScreen = "admin"
                        },

                        icon = {
                            Icon(Icons.Default.Settings, null)
                        },

                        label = {
                            Text("Admin")
                        }
                    )
                }
            }

        ) { paddingValues ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                when (currentScreen) {

                    "home" -> {

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {

                            item {

                                Card(
                                    modifier = Modifier.fillMaxWidth(),

                                    shape = RoundedCornerShape(20.dp),

                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                ) {

                                    Column(
                                        modifier = Modifier.padding(20.dp)
                                    ) {

                                        Text(
                                            text = "Welcome to Grama Angana",
                                            style = MaterialTheme.typography.headlineSmall
                                        )

                                        Spacer(
                                            modifier = Modifier.height(8.dp)
                                        )

                                        Text(
                                            text = "Smart Village Management App"
                                        )

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        OutlinedTextField(
                                            value = "",

                                            onValueChange = {

                                            },

                                            modifier = Modifier.fillMaxWidth(),

                                            label = {
                                                Text("Search Village Services")
                                            }
                                        )

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {

                                            Button(
                                                onClick = {

                                                }
                                            ) {
                                                Text("Events")
                                            }

                                            Button(
                                                onClick = {

                                                }
                                            ) {
                                                Text("Notices")
                                            }

                                            Button(
                                                onClick = {

                                                }
                                            ) {
                                                Text("Help")
                                            }
                                        }

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Card(
                                            modifier = Modifier.fillMaxWidth(),

                                            shape = RoundedCornerShape(20.dp),

                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                                            )
                                        ) {

                                            Column(
                                                modifier = Modifier.padding(20.dp)
                                            ) {

                                                Text(
                                                    text = "Today's Update",
                                                    style = MaterialTheme.typography.titleLarge
                                                )

                                                Spacer(
                                                    modifier = Modifier.height(10.dp)
                                                )

                                                Text(
                                                    text = "Village development work is in progress."
                                                )
                                            }
                                        }

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Text(
                                            text = "Village Development Progress",
                                            style = MaterialTheme.typography.titleLarge
                                        )

                                        Spacer(
                                            modifier = Modifier.height(16.dp)
                                        )

                                        Text("Road Work - 80%")

                                        Spacer(
                                            modifier = Modifier.height(10.dp)
                                        )

                                        LinearProgressIndicator(
                                            progress = { 0.80f },
                                            modifier = Modifier.fillMaxWidth()
                                        )

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Text("Water Project - 60%")

                                        Spacer(
                                            modifier = Modifier.height(10.dp)
                                        )

                                        LinearProgressIndicator(
                                            progress = { 0.60f },
                                            modifier = Modifier.fillMaxWidth()
                                        )

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Text("Street Lights - 90%")

                                        Spacer(
                                            modifier = Modifier.height(10.dp)
                                        )

                                        LinearProgressIndicator(
                                            progress = { 0.90f },
                                            modifier = Modifier.fillMaxWidth()
                                        )

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Card(
                                            modifier = Modifier.fillMaxWidth(),

                                            shape = RoundedCornerShape(20.dp),

                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.tertiaryContainer
                                            )
                                        ) {

                                            Column(
                                                modifier = Modifier.padding(20.dp)
                                            ) {

                                                Text(
                                                    text = "Government Schemes",
                                                    style = MaterialTheme.typography.titleLarge
                                                )

                                                Spacer(
                                                    modifier = Modifier.height(16.dp)
                                                )

                                                Text("• PM Awas Yojana")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• Ayushman Bharat")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• Ujjwala Scheme")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• Farmer Support Program")
                                            }
                                        }

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Card(
                                            modifier = Modifier.fillMaxWidth(),

                                            shape = RoundedCornerShape(20.dp),

                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                                            )
                                        ) {

                                            Column(
                                                modifier = Modifier.padding(20.dp)
                                            ) {

                                                Text(
                                                    text = "Village News",
                                                    style = MaterialTheme.typography.titleLarge
                                                )

                                                Spacer(
                                                    modifier = Modifier.height(16.dp)
                                                )

                                                Text("• New road construction approved")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• Free medical camp this Friday")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• School renovation project started")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("• Water tank cleaning completed")
                                            }
                                        }

                                        Spacer(
                                            modifier = Modifier.height(20.dp)
                                        )

                                        Card(
                                            modifier = Modifier.fillMaxWidth(),

                                            shape = RoundedCornerShape(20.dp),

                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.primaryContainer
                                            )
                                        ) {

                                            Column(
                                                modifier = Modifier.padding(20.dp)
                                            ) {

                                                Text(
                                                    text = "Weather Information",
                                                    style = MaterialTheme.typography.titleLarge
                                                )

                                                Spacer(
                                                    modifier = Modifier.height(16.dp)
                                                )

                                                Text("Temperature : 28°C")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("Climate : Sunny")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("Humidity : 65%")
                                                Spacer(modifier = Modifier.height(10.dp))

                                                Text("Wind Speed : 12 km/h")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    "events" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            Text(
                                text = "Village Events",
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )

                            Text("• Annual Festival")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("• Health Camp")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("• Sports Competition")
                        }
                    }

                    "notices" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            Text(
                                text = "Village Notices",
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )

                            Text("• Water Supply Tomorrow 8AM")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("• Gram Sabha Meeting Sunday")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("• Cleanliness Drive Next Week")
                        }
                    }

                    "maintenance" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            Text(
                                text = "Maintenance",
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )

                            Text("Road repair requests")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("Street light complaints")
                            Spacer(modifier = Modifier.height(10.dp))

                            Text("Water leakage reports")
                        }
                    }

                    "profile" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            Card(
                                modifier = Modifier.fillMaxWidth(),

                                shape = RoundedCornerShape(20.dp)
                            ) {

                                Column(
                                    modifier = Modifier.padding(24.dp)
                                ) {

                                    Text(
                                        text = "Village User",
                                        style = MaterialTheme.typography.headlineSmall
                                    )

                                    Spacer(
                                        modifier = Modifier.height(12.dp)
                                    )

                                    Text("Name : Village Resident")
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text("Mobile : 9876543210")
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text("Village : Grama Angana")
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text("Role : Citizen")
                                }
                            }
                        }
                    }

                    "admin" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {

                            Text(
                                text = "Admin Panel",
                                style = MaterialTheme.typography.headlineSmall
                            )

                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )

                            Card(
                                modifier = Modifier.fillMaxWidth(),

                                shape = RoundedCornerShape(20.dp)
                            ) {

                                Column(
                                    modifier = Modifier.padding(20.dp)
                                ) {

                                    Text(
                                        text = "Manage Village",
                                        style = MaterialTheme.typography.titleLarge
                                    )

                                    Spacer(
                                        modifier = Modifier.height(10.dp)
                                    )

                                    Button(
                                        onClick = {

                                        }
                                    ) {

                                        Text("Add Notice")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}