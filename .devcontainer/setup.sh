#!/bin/bash
echo "🔨 Compiling SetMeal.java..."
javac -d build/classes src/SetMeal.java
echo "✅ Compilation complete!"
echo "🚀 Starting SetMeal POS System..."
echo "========================================"
java -cp build/classes SetMeal
