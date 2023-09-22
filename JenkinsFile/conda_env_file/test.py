import datetime

# Get the current date and time
current_datetime = datetime.datetime.now()
print("Current Date and Time:", current_datetime)

# Get the current date
current_date = current_datetime.date()
print("Current Date:", current_date)

# Get the current time
current_time = current_datetime.time()
print("Current Time:", current_time)

# Format a date as a string
formatted_date = current_date.strftime("%Y-%m-%d")
print("Formatted Date:", formatted_date)

# Parse a date string into a date object
date_str = "2023-09-22"
parsed_date = datetime.datetime.strptime(date_str, "%Y-%m-%d").date()
print("Parsed Date:", parsed_date)
