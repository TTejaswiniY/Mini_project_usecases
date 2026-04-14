def calculate_fare(km,type_of_vehicle,hrs):
    rates={
        'Economy': 10,
        'Premium': 15,
        'Luxury': 20
    }
    try:
        rate=rates[type_of_vehicle]
    except KeyError:
        return "Service Not Available"
    
    base_fare=km*rate
    if 17<=hrs<=20:
        base_fare*=1.5
    return base_fare
try:
    km=float(input("Enter distance in km: "))
    vechicle_type=input("Enter type of vehicle (Economy, Premium, Luxury): ")
    hrs=int(input("Enter hours of travel: "))
    if hrs<0 or hrs>23:
        print("Invalid hours. Please enter a value between 0 and 23.")
    else:
        fare=calculate_fare(km,vechicle_type,hrs)
        if isinstance(fare, str):
            print(fare)
        else:
            print("\n ---------Price Receipt---------")
            print(f"Distance: {km} km")
            print(f"Vehicle Type: {vechicle_type}")
            print(f"Hours of Travel: {hrs}:00 hrs")
            print(f"Total Fare: ${fare:.2f}")
except ValueError:
    print("Invalid input. Please enter numeric values for distance and hours.")