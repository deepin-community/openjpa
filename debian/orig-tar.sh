#!/bin/sh

set -e

# called by uscan with '--upstream-version' <version> <file>
PACKAGE=`dpkg-parsechangelog --show-field Source`
VERSION=$2
TAR=../${PACKAGE}_${VERSION}.orig.tar.xz
DIR=${PACKAGE}-${VERSION}.orig

mkdir $DIR
tar -xf $3 --strip-components=1 -C $DIR
rm $3

XZ_OPT=--best tar --numeric --group 0 --owner 0 -c -v -J -f $TAR \
    --anchored -X debian/orig-tar.excludes $DIR

rm -rf $DIR
