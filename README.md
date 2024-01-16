# Fitness App Documentation

## Introduction

Welcome to the Fitness App, a Kotlin-based application designed to help users maintain a healthy lifestyle. This app combines various features, including water reminder functionality, a Calorie Counter with Room database integration, and a Leaderboard page fetching random data using Retrofit. The navigation is facilitated through a Bottom Navigation Bar, ViewPager2, and Navigation Component, ensuring a seamless user experience.

## Features

### 1. Water Reminder

The Water Reminder feature is implemented using a combination of a Worker and a BroadcastReceiver. The app will remind users to drink water every hour, enhancing hydration throughout the day. The Water Reminder operates in the background, leveraging Android's scheduling capabilities.

#### Implementation Details

- **Worker:** The Worker is responsible for scheduling and executing background tasks. It is configured to run every hour, triggering the water reminder.

- **BroadcastReceiver:** Listens for the scheduled broadcasts from the Worker and responds by displaying a notification reminding the user to drink water.

### 2. Calorie Counter with Room Database

The Calorie Counter feature enables users to track their daily calorie intake. Data is stored locally using the Room database, providing a persistent and efficient solution for managing calorie-related information.

#### Implementation Details

- **Room Database:** The Room library is used for local data storage. It includes entities, DAO (Data Access Object), and a database class. The Calorie Counter data is stored securely on the user's device.

- **Calorie Counter Functionality:** Users can input their daily caloric intake, and the app saves this information in the Room database. The app also provides the ability to view and analyze historical data.

### 3. Leaderboard with Retrofit

The Leaderboard feature enhances user engagement by displaying random data fetched from an external API using Retrofit. Users can explore and compare their fitness achievements with others.

#### Implementation Details

- **Retrofit:** Retrofit is used to handle network requests and API responses. It seamlessly integrates with the app, allowing for efficient retrieval of random fitness data.

- **Leaderboard Page:** The Leaderboard page showcases the fetched random fitness data, offering users a glimpse into the diverse fitness activities of others.

### 4. Navigation

Navigation within the app is streamlined using a combination of the Bottom Navigation Bar, ViewPager2, and Navigation Component.

#### Implementation Details

- **Bottom Navigation Bar:** Located at the bottom of the screen, the navigation bar provides direct access to key sections of the app, enhancing user navigation.

- **ViewPager2:** Implemented for smooth horizontal navigation between app sections, ViewPager2 complements the Bottom Navigation Bar, offering an intuitive and responsive user interface.

- **Navigation Component:** This Android Architecture Component simplifies navigation, allowing for the creation of a more modular and maintainable navigation system.

## Conclusion

The Fitness App is designed to empower users on their journey to a healthier lifestyle. By combining water reminders, a calorie counter with local data storage, and a leaderboard with external API integration, the app offers a comprehensive fitness experience. The navigation system ensures a user-friendly interface, making the Fitness App a valuable companion in achieving and maintaining fitness goals.
