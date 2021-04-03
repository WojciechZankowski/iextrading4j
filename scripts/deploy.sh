#!/bin/bash

set -e # exit with nonzero exit code if anything fails

git clone --quiet --branch=gh-pages https://${GITHUB_TOKEN}@github.com/WojciechZankowski/iextrading4j.git gh-pages > /dev/null

echo "Starting to update gh-pages\n"

#copy data we're interested in to other place
cp -R target/site $HOME/site
cp -R iextrading4j-mutation/target/pit-reports $HOME/site/pit-reports

#go to home and setup git
cd $HOME
git config --global user.email "info@zankowski.pl"
git config --global user.name "Wojciech Zankowski"

#using token clone gh-pages branch
git clone --quiet --branch=gh-pages https://${GITHUB_TOKEN}@github.com/WojciechZankowski/iextrading4j.git gh-pages > /dev/null

#go into directory and copy data we're interested in to that directory
cd gh-pages
cp -Rf $HOME/site/* .

echo "Allow files with underscore https://help.github.com/articles/files-that-start-with-an-underscore-are-missing/" > .nojekyll

#add, commit and push files
git add -f .
git commit -m "Github Action build $GITHUB_RUN_ID"
git push -fq origin gh-pages > /dev/null

echo "Done updating gh-pages\n"

else
 echo "Skipped updating gh-pages, because build is not triggered from the master branch."
fi;
