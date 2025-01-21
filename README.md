# 🎬 CineGo - Movie Booking System

[//]: # (![CineGo Logo]&#40;https://example.com/cinego-logo.png&#41;)

Welcome to **CineGo**, your ultimate console-based application for booking movie tickets! 🎟️

## 📜 Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## 🌟 Introduction
CineGo is a console-based application designed to simplify the process of booking movie tickets. Whether you're a movie enthusiast or just looking for a convenient way to book tickets, CineGo has got you covered!

## ✨ Features
- 🎥 Browse movies currently showing in theaters
- 🕒 Check showtime and availability
- 💺 Select seats and book tickets
- 📜 View booking history
- 🔍 Search for movies by title

## 📂 Folder Structure
<pre style="tab-size: 4">
└── vinayadatiya-cinego/                <br>
    ├── README.md                       <br>
    └── src/                            <br>
        ├── CineGo.java<br>
        ├── Exceptions/<br>
        │   ├── CustomerAlreadyRegistred.java<br>
        │   ├── MovieAlreadyExists.java<br>
        │   ├── ScreenAlreadyExists.java<br>
        │   ├── SeatAlreadyOccupiedException.java<br>
        │   ├── SeatNotFoundException.java<br>
        │   ├── ShowAlreadyExists.java<br>
        │   └── ShowNotAvailableException.java<br>
        ├── Theatre/<br>
        │   ├── Booking.java<br>
        │   ├── Movie.java<br>
        │   ├── MovieTeam.java<br>
        │   ├── PremiumSeat.java<br>
        │   ├── RegularSeat.java<br>
        │   ├── Screen.java<br>
        │   ├── Seat.java<br>
        │   ├── Show.java<br>
        │   └── Theatre.java<br>
        └── Users/<br>
            ├── Admin.java<br>
            ├── Customer.java<br>
            └── Users.java<br>
</pre>

## 🛠️ Installation
To get started with CineGo, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/VinayAdatiya/CineGo.git

2. **Navigate to the project directory:**
    ```bash
    cd cinego
   
3. **Compile the application:**
    ```bash
    javac CineGo.java

4. **Run the application:**
    ```bash
    java CineGo
   
##🚀 Usage
Once the application is up and running, follow the on-screen instructions to navigate through the menu and book your movie tickets. Here's a quick overview:

**1. Browse Movies:** View the list of movies currently showing.

**2. Check Showtimes:** Select a movie to see available showtimes.

**3. Select Seats:** Choose your preferred seats from the available options.

**4. Confirm Booking:** Review your selection and confirm your booking.

**5. View Booking History:** Check your past bookings.

[//]: # (##📸 Screenshots)

##🤝 Contributing
We welcome contributions from the community! If you'd like to contribute to CineGo, please follow these steps:

1. Fork the repository.

2. Create a new branch:
    ```bash
    git checkout -b feature-branch

3. Make your changes and commit them:
    ```bash
    git commit -m "Add new feature"

4. Push to the branch:
    ```bash
    git push origin feature-branch

5. Create a pull request.

