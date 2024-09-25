pwd
false
sudo apt-get install -y mailutils
echo "Mandando email com mailutils do linux" | mail -s "Teste de email" "$RECIPIENT_EMAIL"