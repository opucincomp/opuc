import sqlite3

# Simulate a vulnerable code snippet with SQL Injection
def vulnerable_sql_query(user_input):
    conn = sqlite3.connect(':memory:')
    cursor = conn.cursor()
    
    # NEVER use user input directly in a query like this in a real application
    query = f"SELECT * FROM users WHERE username = '{user_input}'"
    
    cursor.execute(query)
    result = cursor.fetchall()
    conn.close()
    
    return result

# User input (simulating input from a form or an external source)
user_input = "admin' OR '1'='1"

# Call the function with the user input
result = vulnerable_sql_query(user_input)

print("Query result:", result)
