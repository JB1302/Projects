# 🌦️ WeatherAPI Python Demo

A simple Python script to fetch and analyze weather forecasts using [WeatherAPI](https://www.weatherapi.com/).

---

## 🚀 What is this?

This script retrieves a 7-day weather forecast for any location, then analyzes:
- The hottest day
- The coldest day
- How many days exceeded 25°C
- Sorted list of average daily temperatures

---

## 📦 Requirements

- Python 3.8+
- `requests`
- `python-dotenv`

Install dependencies:
```bash
pip install requests python-dotenv


🔑 Setup

    Get your WeatherAPI key: weatherapi.com

    Create a .env file in the project folder:
    API_KEY=your_api_key_here

▶️ Usage
Run the script:
python main.py

When prompted, enter the location you want to search (city, country, etc).
You'll get a summary like this:


Enter the location to search: San José

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Hottest Day: ☀️   °C29.6
Coldest Day: ❄️   °C17.2
Days above 25 degrees: 🔥 #5
Temperature list: 🌡️   ['°C20.7', '°C21.1', '°C22.4', ...]
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

 Code Structure

    obtener_datos_metereologicos: Fetches and processes weather data.

    es_mas_caluroso / es_mas_frio: Finds temperature extremes.

    imprimirValores: Prints a summary of results.

  ⚠️ Notes
  If the API key is missing or invalid, you'll get an error.
  You can tweak the script to display or process more data.


🤝 Credits
Made by someone who prefers to sweat over code, not the weather.