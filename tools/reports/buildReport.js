// https://www.npmjs.com/package/multiple-cucumber-html-reporter

const report = require("multiple-cucumber-html-reporter");

report.generate({
  jsonDir: "./json",
  reportPath: "./report",
});
