#!/bin/bash

set -e

./gradlew :app:connectedDebugAndroidTest || true

rm -rf tools/reports/json tools/reports/report
mkdir -p tools/reports/json tools/reports/report
find app/build/outputs/connected_android_test_additional_output/debugAndroidTest/ -name "*.json" -print0 | xargs -I"{}" -0 cp "{}" tools/reports/json/

cd tools/reports
npm ci
npm run buildReport
