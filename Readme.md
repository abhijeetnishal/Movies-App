# MovieApp
MovieApp is an Android application similar to IMDb that fetches data from the TMDB (The Movie
Database) API. The app follows the MVVM (Model-View-ViewModel) architecture and utilizes Jetpack
Compose for UI development.

## Features
- Browse popular and top rated movies
- View detailed information about a selected movie
- MVVM architecture for clean and maintainable code
- Jetpack Compose for modern and reactive UI

[//]: # ()
[//]: # (## Screenshots)

[//]: # (![Home Screen]&#40;screenshots/home_screen.png&#41;)

[//]: # (*Home Screen*)

[//]: # ()
[//]: # (![Movie Details Screen]&#40;screenshots/movie_details_screen.png&#41;)

[//]: # (*Movie Details Screen*)

## Architecture
This app is built using the MVVM architecture, which helps in maintaining a clean separation of
concerns. Here's a brief overview of the architecture components:

- **Model**: Handles the data layer of the app, including data sources and repositories.
- **ViewModel**: Acts as a bridge between the View and the Model. It provides data to the UI and
  manages UI-related logic in a lifecycle-conscious way.
- **View**: The UI layer of the app, built with Jetpack Compose, which observes the data exposed by
  the ViewModel.

## Tech Stack
- **Kotlin**: The programming language used for the app.
- **Jetpack Compose**: For building the UI.
- **Retrofit**: For networking and making API calls.
- **Dagger Hilt**: For dependency injection.
- **Coroutines**: For asynchronous programming.
- **TMDB API**: The external service used for fetching movie data.

### Prerequisites
- Android Studio Chipmunk (or later)
- Kotlin 1.7.0 (or later)
- An API key from [TMDB](https://www.themoviedb.org/documentation/api)

