

# Fetch Reward Application

## Video
[Fetch Reward Application Gif.webm](https://github.com/user-attachments/assets/f66c6c97-ddc8-49bb-8703-a1c02456c078)

## Image
![Fetch_Reward_ScreenShot](https://github.com/user-attachments/assets/396e5b29-492d-4a72-a1d8-77fa4e859cc9)

## Question 

Please write a native Android app in Kotlin or Java that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.

Display this list of items to the user based on the following requirements:

Display all the items grouped by "listId"
Sort the results first by "listId" then by "name" when displaying.
Filter out any items where "name" is blank or null.
The final result should be displayed to the user in an easy-to-read list.

## Tech stack:

- Programming Languages: Kotlin
- Build System: Gradle
- Architecture: Model-View-ViewModel (MVVM)
- UI: Jetpack Compose
- Dependency Injection: Hilt/Dagger
- Networking: Retrofit2
- Version Control: Git
- Asynchronous Programming: Kotlin Coroutines


## Notes
Application uses [clean architecture with MVVM pattern]
- Separation of concerns, domain, data and ui layers as per Google recommendations
- Dependencies are managed through the [version catalogs]
