# usage1 : console > ./push.sh
# usage2 : console > ./push.sh "MESSAGE"
if [ -z "$1" ]; then
	msg="m"
else
	msg="$1"
fi
git pull
git add .
git commit -am "$msg"
git push