# E-commerce System - Internship Task

This project implements a console-based e-commerce system using the Composition Over Inheritance design principle to provide flexibility for product behaviors.

## Features

- Products have:
  - Name, price, and quantity.
  - Configurable expiration behavior (expirable or non-expirable).
  - Configurable shipping behavior (shippable or non-shippable with weight).
- Customers can:
  - Add products to a cart with stock validation.
  - Checkout with automatic stock reduction and balance deduction.
- Expired products cannot be purchased.
- Shipping details printed for all shippable products.
- Error handling for:
  - Insufficient stock.
  - Insufficient balance.
  - Expired products.
  - Empty cart.

## Notes

- Shipping fees are calculated as **5 EGP per kilogram**, as a simple assumption for this demo.
- The system demonstrates various product combinations:
  - Expirable and shippable (e.g., Cheese).
  - Non-expirable and shippable (e.g., TV).
  - Expirable and non-shippable (e.g., Scratch Cards).

## Class Diagram

![Class Diagram](class-diagram.png)

## Technologies

- Java
- No external libraries required
